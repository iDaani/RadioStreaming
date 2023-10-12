
package jsonFiles;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "album",
    "external_ids",
    "popularity",
    "is_playable",
    "linked_from",
    "artists",
    "available_markets",
    "disc_number",
    "duration_ms",
    "explicit",
    "external_urls",
    "href",
    "id",
    "name",
    "preview_url",
    "track_number",
    "uri"
})
@Generated("jsonschema2pojo")
public class Spotify {

    @JsonProperty("album")
    private Album album;
    @JsonProperty("external_ids")
    private ExternalIds externalIds;
    @JsonProperty("popularity")
    private Integer popularity;
    @JsonProperty("is_playable")
    private Object isPlayable;
    @JsonProperty("linked_from")
    private Object linkedFrom;
    @JsonProperty("artists")
    private List<Artist__1> artists = new ArrayList<Artist__1>();
    @JsonProperty("available_markets")
    private List<String> availableMarkets = new ArrayList<String>();
    @JsonProperty("disc_number")
    private Integer discNumber;
    @JsonProperty("duration_ms")
    private Integer durationMs;
    @JsonProperty("explicit")
    private Boolean explicit;
    @JsonProperty("external_urls")
    private ExternalUrls__3 externalUrls;
    @JsonProperty("href")
    private String href;
    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("preview_url")
    private String previewUrl;
    @JsonProperty("track_number")
    private Integer trackNumber;
    @JsonProperty("uri")
    private String uri;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("album")
    public Album getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(Album album) {
        this.album = album;
    }

    public Spotify withAlbum(Album album) {
        this.album = album;
        return this;
    }

    @JsonProperty("external_ids")
    public ExternalIds getExternalIds() {
        return externalIds;
    }

    @JsonProperty("external_ids")
    public void setExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
    }

    public Spotify withExternalIds(ExternalIds externalIds) {
        this.externalIds = externalIds;
        return this;
    }

    @JsonProperty("popularity")
    public Integer getPopularity() {
        return popularity;
    }

    @JsonProperty("popularity")
    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    public Spotify withPopularity(Integer popularity) {
        this.popularity = popularity;
        return this;
    }

    @JsonProperty("is_playable")
    public Object getIsPlayable() {
        return isPlayable;
    }

    @JsonProperty("is_playable")
    public void setIsPlayable(Object isPlayable) {
        this.isPlayable = isPlayable;
    }

    public Spotify withIsPlayable(Object isPlayable) {
        this.isPlayable = isPlayable;
        return this;
    }

    @JsonProperty("linked_from")
    public Object getLinkedFrom() {
        return linkedFrom;
    }

    @JsonProperty("linked_from")
    public void setLinkedFrom(Object linkedFrom) {
        this.linkedFrom = linkedFrom;
    }

    public Spotify withLinkedFrom(Object linkedFrom) {
        this.linkedFrom = linkedFrom;
        return this;
    }

    @JsonProperty("artists")
    public List<Artist__1> getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(List<Artist__1> artists) {
        this.artists = artists;
    }

    public Spotify withArtists(List<Artist__1> artists) {
        this.artists = artists;
        return this;
    }

    @JsonProperty("available_markets")
    public List<String> getAvailableMarkets() {
        return availableMarkets;
    }

    @JsonProperty("available_markets")
    public void setAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
    }

    public Spotify withAvailableMarkets(List<String> availableMarkets) {
        this.availableMarkets = availableMarkets;
        return this;
    }

    @JsonProperty("disc_number")
    public Integer getDiscNumber() {
        return discNumber;
    }

    @JsonProperty("disc_number")
    public void setDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
    }

    public Spotify withDiscNumber(Integer discNumber) {
        this.discNumber = discNumber;
        return this;
    }

    @JsonProperty("duration_ms")
    public Integer getDurationMs() {
        return durationMs;
    }

    @JsonProperty("duration_ms")
    public void setDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
    }

    public Spotify withDurationMs(Integer durationMs) {
        this.durationMs = durationMs;
        return this;
    }

    @JsonProperty("explicit")
    public Boolean getExplicit() {
        return explicit;
    }

    @JsonProperty("explicit")
    public void setExplicit(Boolean explicit) {
        this.explicit = explicit;
    }

    public Spotify withExplicit(Boolean explicit) {
        this.explicit = explicit;
        return this;
    }

    @JsonProperty("external_urls")
    public ExternalUrls__3 getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("external_urls")
    public void setExternalUrls(ExternalUrls__3 externalUrls) {
        this.externalUrls = externalUrls;
    }

    public Spotify withExternalUrls(ExternalUrls__3 externalUrls) {
        this.externalUrls = externalUrls;
        return this;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    public Spotify withHref(String href) {
        this.href = href;
        return this;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Spotify withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Spotify withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("preview_url")
    public String getPreviewUrl() {
        return previewUrl;
    }

    @JsonProperty("preview_url")
    public void setPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
    }

    public Spotify withPreviewUrl(String previewUrl) {
        this.previewUrl = previewUrl;
        return this;
    }

    @JsonProperty("track_number")
    public Integer getTrackNumber() {
        return trackNumber;
    }

    @JsonProperty("track_number")
    public void setTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
    }

    public Spotify withTrackNumber(Integer trackNumber) {
        this.trackNumber = trackNumber;
        return this;
    }

    @JsonProperty("uri")
    public String getUri() {
        return uri;
    }

    @JsonProperty("uri")
    public void setUri(String uri) {
        this.uri = uri;
    }

    public Spotify withUri(String uri) {
        this.uri = uri;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Spotify withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Spotify.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("album");
        sb.append('=');
        sb.append(((this.album == null)?"<null>":this.album));
        sb.append(',');
        sb.append("externalIds");
        sb.append('=');
        sb.append(((this.externalIds == null)?"<null>":this.externalIds));
        sb.append(',');
        sb.append("popularity");
        sb.append('=');
        sb.append(((this.popularity == null)?"<null>":this.popularity));
        sb.append(',');
        sb.append("isPlayable");
        sb.append('=');
        sb.append(((this.isPlayable == null)?"<null>":this.isPlayable));
        sb.append(',');
        sb.append("linkedFrom");
        sb.append('=');
        sb.append(((this.linkedFrom == null)?"<null>":this.linkedFrom));
        sb.append(',');
        sb.append("artists");
        sb.append('=');
        sb.append(((this.artists == null)?"<null>":this.artists));
        sb.append(',');
        sb.append("availableMarkets");
        sb.append('=');
        sb.append(((this.availableMarkets == null)?"<null>":this.availableMarkets));
        sb.append(',');
        sb.append("discNumber");
        sb.append('=');
        sb.append(((this.discNumber == null)?"<null>":this.discNumber));
        sb.append(',');
        sb.append("durationMs");
        sb.append('=');
        sb.append(((this.durationMs == null)?"<null>":this.durationMs));
        sb.append(',');
        sb.append("explicit");
        sb.append('=');
        sb.append(((this.explicit == null)?"<null>":this.explicit));
        sb.append(',');
        sb.append("externalUrls");
        sb.append('=');
        sb.append(((this.externalUrls == null)?"<null>":this.externalUrls));
        sb.append(',');
        sb.append("href");
        sb.append('=');
        sb.append(((this.href == null)?"<null>":this.href));
        sb.append(',');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("previewUrl");
        sb.append('=');
        sb.append(((this.previewUrl == null)?"<null>":this.previewUrl));
        sb.append(',');
        sb.append("trackNumber");
        sb.append('=');
        sb.append(((this.trackNumber == null)?"<null>":this.trackNumber));
        sb.append(',');
        sb.append("uri");
        sb.append('=');
        sb.append(((this.uri == null)?"<null>":this.uri));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.isPlayable == null)? 0 :this.isPlayable.hashCode()));
        result = ((result* 31)+((this.previewUrl == null)? 0 :this.previewUrl.hashCode()));
        result = ((result* 31)+((this.trackNumber == null)? 0 :this.trackNumber.hashCode()));
        result = ((result* 31)+((this.album == null)? 0 :this.album.hashCode()));
        result = ((result* 31)+((this.linkedFrom == null)? 0 :this.linkedFrom.hashCode()));
        result = ((result* 31)+((this.externalIds == null)? 0 :this.externalIds.hashCode()));
        result = ((result* 31)+((this.externalUrls == null)? 0 :this.externalUrls.hashCode()));
        result = ((result* 31)+((this.uri == null)? 0 :this.uri.hashCode()));
        result = ((result* 31)+((this.explicit == null)? 0 :this.explicit.hashCode()));
        result = ((result* 31)+((this.discNumber == null)? 0 :this.discNumber.hashCode()));
        result = ((result* 31)+((this.artists == null)? 0 :this.artists.hashCode()));
        result = ((result* 31)+((this.popularity == null)? 0 :this.popularity.hashCode()));
        result = ((result* 31)+((this.availableMarkets == null)? 0 :this.availableMarkets.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.href == null)? 0 :this.href.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.durationMs == null)? 0 :this.durationMs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Spotify) == false) {
            return false;
        }
        Spotify rhs = ((Spotify) other);
        return (((((((((((((((((((this.isPlayable == rhs.isPlayable)||((this.isPlayable!= null)&&this.isPlayable.equals(rhs.isPlayable)))&&((this.previewUrl == rhs.previewUrl)||((this.previewUrl!= null)&&this.previewUrl.equals(rhs.previewUrl))))&&((this.trackNumber == rhs.trackNumber)||((this.trackNumber!= null)&&this.trackNumber.equals(rhs.trackNumber))))&&((this.album == rhs.album)||((this.album!= null)&&this.album.equals(rhs.album))))&&((this.linkedFrom == rhs.linkedFrom)||((this.linkedFrom!= null)&&this.linkedFrom.equals(rhs.linkedFrom))))&&((this.externalIds == rhs.externalIds)||((this.externalIds!= null)&&this.externalIds.equals(rhs.externalIds))))&&((this.externalUrls == rhs.externalUrls)||((this.externalUrls!= null)&&this.externalUrls.equals(rhs.externalUrls))))&&((this.uri == rhs.uri)||((this.uri!= null)&&this.uri.equals(rhs.uri))))&&((this.explicit == rhs.explicit)||((this.explicit!= null)&&this.explicit.equals(rhs.explicit))))&&((this.discNumber == rhs.discNumber)||((this.discNumber!= null)&&this.discNumber.equals(rhs.discNumber))))&&((this.artists == rhs.artists)||((this.artists!= null)&&this.artists.equals(rhs.artists))))&&((this.popularity == rhs.popularity)||((this.popularity!= null)&&this.popularity.equals(rhs.popularity))))&&((this.availableMarkets == rhs.availableMarkets)||((this.availableMarkets!= null)&&this.availableMarkets.equals(rhs.availableMarkets))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.href == rhs.href)||((this.href!= null)&&this.href.equals(rhs.href))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.durationMs == rhs.durationMs)||((this.durationMs!= null)&&this.durationMs.equals(rhs.durationMs))));
    }

}
