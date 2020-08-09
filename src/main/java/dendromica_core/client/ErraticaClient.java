package dendromica_core.client;

import dendromica_core.mixin.client.ArmorFeatureRendererAccessor;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.util.Identifier;

public class ErraticaClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        preRegisterArmorTextures(new Identifier("dendromica_core", "eurenite"), false);
    }

    private void preRegisterArmorTextures(Identifier name, boolean hasOverlay) {
        for (int layer = 1; layer <= 2; layer++) {
            preRegisterArmorTexture(name, layer, null);
            if (hasOverlay) {
                preRegisterArmorTexture(name, layer, "overlay");
            }
        }
    }

    private void preRegisterArmorTexture(Identifier name, int layer, String extra) {
        String key = "textures/models/armor/" + name + "_layer_" + layer + (extra == null ? "" : "_" + extra) + ".png";
        Identifier value = new Identifier(name.getNamespace(), "textures/models/armor/" + name.getPath() + "_layer_" + layer + (extra == null ? "" : "_" + extra) + ".png");
        ArmorFeatureRendererAccessor.getArmorTextureCache().put(key, value);
    }
}
