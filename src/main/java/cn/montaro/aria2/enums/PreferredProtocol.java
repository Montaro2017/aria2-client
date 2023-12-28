package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PreferredProtocol {

    NONE("none"),
    HTTP("http"),
    HTTPS("https"),
    FTP("ftp");
    private final String value;
}
