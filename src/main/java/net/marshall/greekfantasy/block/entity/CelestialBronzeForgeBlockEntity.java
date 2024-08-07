package net.marshall.greekfantasy.block.entity;

import net.marshall.greekfantasy.item.ModItems;
import net.marshall.greekfantasy.screen.CelestialBronzeForgeMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class CelestialBronzeForgeBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemHandler = new ItemStackHandler(4) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return switch (slot) {
                case 0 -> stack.getItem() == ModItems.ROUGH_MOLTEN_CELESTIAL_BRONZE_BUCKET.get();
                case 1 -> stack.getItem() == Items.LAVA_BUCKET;
                case 2 -> false;
                case 3 -> false;
                default -> super.isItemValid(slot, stack);
            };
        }
    };

    private static final int INPUT_SLOT = 0;
    private static final int LAVA_INPUT_SLOT = 1;
    private static final int CELESTIAL_BRONZE_OUTPUT_SLOT = 2;
    private static final int CELESTIAL_BRONZE_SLAG_SLOT = 3;

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 78;

    public CelestialBronzeForgeBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.CELESTIAL_BRONZE_FORGE_BE.get(), pPos, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int pIndex) {
                return switch (pIndex) {
                    case 0 -> CelestialBronzeForgeBlockEntity.this.progress;
                    case 1 -> CelestialBronzeForgeBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int pIndex, int pValue) {
                switch (pIndex) {
                    case 0 -> CelestialBronzeForgeBlockEntity.this.progress = pValue;
                    case 1 -> CelestialBronzeForgeBlockEntity.this.maxProgress = pValue;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Gem Empowering Station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pPlayerInventory, Player pPlayer) {
        return new CelestialBronzeForgeMenu(pContainerId, pPlayerInventory, this, this.data);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if (cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("celestial_bronze_forge.progress", progress);

        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("celestial_bronze_forge.progress");

    }

    public void tick(Level level, BlockPos pPos, BlockState pState) {
        if (isOutputSlotEmptyOrReceivable() && hasRecipe()) {
            increaseCraftingProcess();
            setChanged(level, pPos, pState);

            if (hasProgressFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        this.itemHandler.extractItem(INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT, new ItemStack(ModItems.CELESTIAL_BRONZE_INGOT.get(),
                this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).getCount() + 1));

        this.itemHandler.extractItem(LAVA_INPUT_SLOT, 1, false);

        this.itemHandler.setStackInSlot(CELESTIAL_BRONZE_SLAG_SLOT, new ItemStack(ModItems.CELESTIAL_BRONZE_SLAG.get(),
                this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_SLAG_SLOT).getCount() +1));
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasProgressFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProcess() {
        this.progress++;
    }

    private boolean hasRecipe() {
        return canInsertAmountIntoOutputSlot(1) && canInsertItemIntoOutputSlot(ModItems.CELESTIAL_BRONZE_INGOT.get())
                && hasRecipeItemInInputSlot();
    }

    private boolean hasRecipeItemInInputSlot() {
        return this.itemHandler.getStackInSlot(INPUT_SLOT).getItem() == ModItems.ROUGH_MOLTEN_CELESTIAL_BRONZE_BUCKET.get();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).isEmpty() || this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).is(item);
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).getMaxStackSize() >=
                this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).getCount() + count;
    }

    private boolean isOutputSlotEmptyOrReceivable() {
        return this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).isEmpty() ||
                this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).getCount() < this.itemHandler.getStackInSlot(CELESTIAL_BRONZE_OUTPUT_SLOT).getMaxStackSize();
    }
}