package dendromica_core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Infuser extends Block {
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager){
        stateManager.add(ACTIVATED);
    }
    public Infuser(Settings settings){
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(ACTIVATED, false));
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit){
        if(state.get(ACTIVATED))
            world.setBlockState(pos, state.with(ACTIVATED, false));
        else
            world.setBlockState(pos, state.with(ACTIVATED, true));
        return ActionResult.SUCCESS;
    }
}
