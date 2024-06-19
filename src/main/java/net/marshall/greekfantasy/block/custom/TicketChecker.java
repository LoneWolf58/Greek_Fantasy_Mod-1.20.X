package net.marshall.greekfantasy.block.custom;

import net.marshall.greekfantasy.GreekFantasy;
import net.marshall.greekfantasy.block.ModBlocks;
import net.marshall.greekfantasy.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;

import java.util.logging.Logger;

public class TicketChecker extends ButtonBlock {


    public TicketChecker(Properties pProperties, BlockSetType pType, int pTicksToStayPressed, boolean pArrowsCanPress) {
        super(pProperties, pType, pTicksToStayPressed, pArrowsCanPress);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos,
                                 Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        if (!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND) {
            if(pPlayer.isHolding(ModItems.TRAIN_TICKET.get())){
                GreekFantasy.LOGGER.info("Pressed with Ticket");

            } else {GreekFantasy.LOGGER.info("Pressed Without Ticket");}
        }

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }

    @Override
    public int getSignal(BlockState pState, BlockGetter pLevel, BlockPos pPos, Direction pDirection) {
        return true ? 15 : 0;
    }

    @Override
    public boolean isSignalSource(BlockState pState) { return true; }
}
