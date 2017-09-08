package am.plexonic.core.manager.util.converter.dau;

import am.plexonic.common.dto.dau.DAUDto;
import am.plexonic.core.manager.util.converter.base.BaseConverter;
import am.plexonic.core.manager.model.DAU;
import org.springframework.stereotype.Component;

/**
 * DAU converter
 */
@Component
public class DAUConverter extends BaseConverter<DAU, DAUDto> {
    @Override
    public DAUDto convert(DAU source) {
        DAUDto target = new DAUDto();
        target.setUserId(source.getUserId());
        return target;
    }
}
