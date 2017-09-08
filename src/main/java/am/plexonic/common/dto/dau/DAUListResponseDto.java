package am.plexonic.common.dto.dau;

import am.plexonic.common.dto.general.ResponseDto;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * DAU list response dto object
 */
@XmlRootElement
public class DAUListResponseDto extends ResponseDto {
    private static final long serialVersionUID = 1L;

    private List<DAUDto> dtoList;

    public List<DAUDto> getDtoList() {
        return dtoList;
    }

    public void setDtoList(List<DAUDto> dtoList) {
        this.dtoList = dtoList;
    }
}
