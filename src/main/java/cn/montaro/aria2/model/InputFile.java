package cn.montaro.aria2.model;

import cn.montaro.aria2.enums.*;
import cn.montaro.aria2.gson.CommaAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * <a href="https://aria2.github.io/manual/en/html/aria2c.html#id2">Input File</a>
 */
@Data
@Accessors(chain = true)
public class InputFile {
    private String allProxy;
    private String allProxyPasswd;
    private String allProxyUser;
    private Boolean allowOverwrite;
    private Boolean allowPieceLengthChange;
    private Boolean alwaysResume;
    private Boolean asyncDns;
    private Boolean autoFileRenaming;
    private Boolean btEnableHookAfterHashCheck;
    private Boolean btEnableLpd;
    @JsonAdapter(CommaAdapter.class)
    private List<String> btExcludeTracker;
    private String btExternalIp;
    private Boolean btForceEncryption;
    private Boolean btHashCheckSeed;
    private Boolean btLoadSavedMetadata;
    private String btLpdInterface;
    private Integer btMaxOpenFiles;
    private Integer btMaxPeers;
    private Boolean btMetadataOnly;
    private CryptoLevel btMinCryptoLevel;
    private String btPrioritizePiece;
    private Boolean btRemoveUnselectedFile;
    private Boolean btRequireCrypto;
    private String btRequestPeerSpeedLimit;
    private Boolean btSaveMetadata;
    private Boolean btSeedUnverified;
    private Integer btStopTimeout;
    @JsonAdapter(CommaAdapter.class)
    private List<String> btTracker;
    private Integer btTrackerConnectTimeout;
    private Integer btTrackerInterval;
    private Integer btTrackerTimeout;
    private Boolean checkIntegrity;
    private String checksum;
    private Boolean conditionGet;
    private Integer connectTimeout;
    private Boolean contentDispositionDefaultUtf8;
    @SerializedName("continue")
    private Boolean continueDownloading;
    private String dir;
    private Boolean dryRun;
    private Boolean enableHttpKeepAlive;
    private Boolean enableHttpPipelining;
    private Boolean enableMmap;
    private Boolean enablePeerExchange;
    private FileAllocation fileAllocation;
    private Follow followMetalink;
    private Follow followTorrent;
    private Boolean forceSave;
    private String ftpPasswd;
    private Boolean ftpPasv;
    private String ftpProxy;
    private String ftpProxyPasswd;
    private String ftpProxyUser;
    private Boolean ftpReuseConnection;
    private FTPType ftpType;
    private String ftpUser;
    private String gid;
    private Boolean hashCheckOnly;
    private String header;
    private Boolean httpAcceptGzip;
    private Boolean httpAuthChallenge;
    private Boolean httpNoCache;
    private String httpPasswd;
    private String httpProxy;
    private String httpProxyPasswd;
    private String httpProxyUser;
    private String httpUser;
    private String httpsProxy;
    private String httpsProxyPasswd;
    private String httpsProxyUser;
    private String indexOut;
    private String lowestSpeedLimit;
    private Integer maxConnectionPerServer;
    private String maxDownloadLimit;
    private Integer maxFileNotFound;
    private Long maxMmapLimit;
    private Integer maxResumeFailureTries;
    private Integer maxTries;
    private String maxUploadLimit;
    private String metalinkBaseUri;
    private Boolean metalinkEnableUniqueProtocol;
    private String metalinkLanguage;
    private String metalinkLocation;
    private String metalinkOs;
    private PreferredProtocol metalinkPreferredProtocol;
    private String metalinkVersion;
    private Integer minSplitSize;
    private String noFileAllocationLimit;
    private Boolean noNetrc;
    @JsonAdapter(CommaAdapter.class)
    private List<String> noProxy;
    private String out;
    private Boolean parameterizedUri;
    private Boolean pause;
    private Boolean pauseMetadata;
    private String pieceLength;
    private ProxyMethod proxyMethod;
    private Boolean realtimeChunkChecksum;
    private String referer;
    private Boolean remoteTime;
    private Boolean removeControlFile;
    private Integer retryWait;
    private Boolean reuseUri;
    private Boolean rpcSaveUploadMetadata;
    private Double seedRatio;
    private Integer seedTime;
    private String selectFile;
    private Integer split;
    private String sshHostKeyMd;
    private StreamPieceSelector streamPieceSelector;
    private Integer timeout;
    private UriSelector uriSelector;
    private Boolean useHead;
    private String userAgent;
}
