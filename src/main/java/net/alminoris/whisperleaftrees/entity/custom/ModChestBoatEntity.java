package net.alminoris.whisperleaftrees.entity.custom;

import net.alminoris.whisperleaftrees.entity.ModEntities;
import net.alminoris.whisperleaftrees.util.helper.ModBlockSetsHelper;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class ModChestBoatEntity extends ChestBoat
{
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE = SynchedEntityData.defineId(ModChestBoatEntity.class, EntityDataSerializers.INT);

    public ModChestBoatEntity(EntityType<? extends ChestBoat> pEntityType, Level pLevel)
    {
        super(pEntityType, pLevel);
    }

    public ModChestBoatEntity(Level pLevel, double pX, double pY, double pZ)
    {
        this(ModEntities.MOD_CHEST_BOAT.get(), pLevel);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem()
    {
        switch (getModVariant())
        {
            case WILLOW -> {
                return ModBlockSetsHelper.WOODEN_CHEST_BOATS.get("willow").get();
            }

            case POPLAR -> {
                return ModBlockSetsHelper.WOODEN_CHEST_BOATS.get("poplar").get();
            }

            case ALDER -> {
                return ModBlockSetsHelper.WOODEN_CHEST_BOATS.get("alder").get();
            }

            case ASPEN -> {
                return ModBlockSetsHelper.WOODEN_CHEST_BOATS.get("aspen").get();
            }
        }
        return super.getDropItem();
    }

    public void setVariant(ModBoatEntity.Type pVariant)
    {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder)
    {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, ModBoatEntity.Type.WILLOW.ordinal());
    }

    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
    }

    protected void readAdditionalSaveData(CompoundTag pCompound)
    {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(ModBoatEntity.Type.byName(pCompound.getString("Type")));
        }
    }

    public ModBoatEntity.Type getModVariant() {
        return ModBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }
}