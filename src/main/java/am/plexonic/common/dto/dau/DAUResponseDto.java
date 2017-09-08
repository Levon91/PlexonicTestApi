package am.plexonic.common.dto.dau;

import am.plexonic.common.dto.general.ResponseDto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * DAU response dto object
 */
@XmlRootElement
public class DAUResponseDto extends ResponseDto {
    private static final long serialVersionUID = 1L;

    private DAUDto dauDto;

    public DAUDto getDauDto() {
        return dauDto;
    }

    public void setDauDto(DAUDto dauDto) {
        this.dauDto = dauDto;
    }
}
