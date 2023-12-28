package cn.montaro.aria2.enums;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum FileAllocation {
    @SerializedName(value = "none")
    NONE("none"),
    @SerializedName(value = "prealloc")
    PRE_ALLOC("prealloc"),
    @SerializedName(value = "trunc")
    TRUNC("trunc"),
    @SerializedName(value = "falloc")
    F_ALLOC("falloc");
    private final String value;
}
