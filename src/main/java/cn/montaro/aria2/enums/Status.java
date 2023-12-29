package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Status implements EnumValue<String> {

    ACTIVE("active"),
    WAITING("waiting"),
    PAUSED("paused"),
    ERROR("error"),
    COMPLETE("complete"),
    REMOVED("removed");
    private final String value;

}
