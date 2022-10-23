package com.jetpacker06.CreateBrokenBad.entity;

import com.jetpacker06.CreateBrokenBad.CreateBrokenBad;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class BoombleEntityRenderer<Type extends BoombleEntity> extends MobRenderer<Type, BoombleEntityModel<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(CreateBrokenBad.MOD_ID, "textures/boombletexture.png");

    public BoombleEntityRenderer(EntityRendererProvider.Context context) {
        super(context, new BoombleEntityModel<>(context.bakeLayer(BoombleEntityModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(BoombleEntity pEntity) {
        return TEXTURE;
    }
}
