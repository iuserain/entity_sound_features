package traben.entity_sound_features.properties;

import org.jetbrains.annotations.NotNull;
import traben.entity_sound_features.ESFSoundContext;
import traben.entity_texture_features.features.property_reading.properties.RandomProperty;
import traben.entity_texture_features.features.property_reading.properties.generic_properties.SimpleIntegerArrayProperty;
import traben.entity_texture_features.features.state.ETFEntityRenderState;
import traben.entity_texture_features.utils.ETFEntity;

import java.util.Properties;

public class SoundSuffixProperty extends SimpleIntegerArrayProperty {
    protected SoundSuffixProperty(Properties properties, int propertyNum) throws RandomProperty.RandomPropertyException {
        super(getGenericIntegerSplitWithRanges(properties, propertyNum, "soundSuffix", "sound_suffix"));
    }

    public static SoundSuffixProperty getPropertyOrNull(Properties properties, int propertyNum) {
        try {
            return new SoundSuffixProperty(properties, propertyNum);
        } catch (RandomProperty.RandomPropertyException var3) {
            return null;
        }
    }

    public @NotNull String[] getPropertyIds() {
        return new String[]{"soundSuffix", "sound_suffix"};
    }

    protected int getValueFromEntity(ETFEntityRenderState entity) {
        int val = ESFSoundContext.lastSuffix.getInt(entity.uuid());
        return Math.max(val, 0);
    }
}
