package traben.entity_sound_features.properties;

import org.jetbrains.annotations.NotNull;
import traben.entity_sound_features.ESFSoundContext;
import traben.entity_texture_features.features.property_reading.properties.generic_properties.SimpleIntegerArrayProperty;
import traben.entity_texture_features.features.state.ETFEntityRenderState;
import traben.entity_texture_features.utils.ETFEntity;

import java.util.Properties;

public class SoundRuleIndexProperty extends SimpleIntegerArrayProperty {
    protected SoundRuleIndexProperty(Properties properties, int propertyNum) throws RandomPropertyException {
        super(getGenericIntegerSplitWithRanges(properties, propertyNum, "soundRule", "sound_rule"));
    }

    public static SoundRuleIndexProperty getPropertyOrNull(Properties properties, int propertyNum) {
        try {
            return new SoundRuleIndexProperty(properties, propertyNum);
        } catch (RandomPropertyException var3) {
            return null;
        }
    }

    public @NotNull String[] getPropertyIds() {
        return new String[]{"soundRule", "sound_rule"};
    }

    protected int getValueFromEntity(ETFEntityRenderState entity) {
        int val = ESFSoundContext.lastRuleMet.getInt(entity.uuid());
        return Math.max(val, 0);
    }
}
