package dendromica_core.mixin.client;

import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(ArmorFeatureRenderer.class)
public interface ArmorFeatureRendererAccessor {
    @Accessor("ARMOR_TEXTURE_CACHE")
    static Map<String, Identifier> getArmorTextureCache() {
        throw new RuntimeException();
    }
}
