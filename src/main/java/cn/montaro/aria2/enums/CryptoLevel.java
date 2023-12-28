package cn.montaro.aria2.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CryptoLevel {

    @SerializedName(value = "plain")
    PLAIN("plain"),
    @SerializedName(value = "arc4")
    ARC4("arc4");
    private final String value;

}
