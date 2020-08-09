package dendromica_core;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.collection.DefaultedList;

public class InfuserEntity extends BlockEntity{
    private  DefaultedList<ItemStack> inventory;
    public InfuserEntity(BlockEntityType<?> type) {
        super(type);
        this.inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);
    }
    public InfuserEntity(){
        this(DendromicaCoreItems.INFUSER_ENTITY);
    }
    @Override
    public CompoundTag toTag(CompoundTag tag){
        Inventories.toTag(tag, inventory);
        return super.toTag(tag);
    }
    @Override
    public void fromTag(BlockState state, CompoundTag tag){
        super.fromTag(state, tag);
        Inventories.fromTag(tag, inventory);
    }
}
