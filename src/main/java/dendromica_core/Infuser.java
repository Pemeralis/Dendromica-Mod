package dendromica_core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Infuser extends Block implements BlockEntityProvider {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager){
        stateManager.add(ACTIVATED);
    }
    public Infuser(Settings settings){
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(ACTIVATED, false));
    }
    /**
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(state.get(ACTIVATED))
            world.setBlockState(pos, state.with(ACTIVATED, false));
        else
            world.setBlockState(pos, state.with(ACTIVATED, true));
        return ActionResult.SUCCESS;
    }
    */
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;
        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);
        if (!player.getStackInHand(hand).isEmpty()) {
            // Check what is the first open slot and put an item from the player's hand there
            if (blockEntity.getStack(0).isEmpty()) {
                // Put the stack the player is holding into the inventory
                blockEntity.setStack(0, player.getStackInHand(hand).copy());
                // Remove the stack from the player's hand
                player.getStackInHand(hand).setCount(0);
            } else if (blockEntity.getStack(1).isEmpty()) {
                blockEntity.setStack(1, player.getStackInHand(hand).copy());
                player.getStackInHand(hand).setCount(0);
            } else {
                // If the inventory is full we'll print it's contents
                System.out.println("The first slot holds "
                        + blockEntity.getStack(0) + " and the second slot holds " + blockEntity.getStack(1));
            }
        }
        return ActionResult.SUCCESS;
    }
    @Override
    public BlockEntity createBlockEntity(BlockView blockView) {
        return new InfuserEntity();
    }
}
