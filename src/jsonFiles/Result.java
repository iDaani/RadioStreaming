
package jsonFiles;

import java.util.LinkedHashMap;
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
    "artist",
    "title",
    "album",
    "release_date",
    "label",
    "timecode",
    "song_link",
    "spotify"
})
@Generated("jsonschema2pojo")
public class Result {

    @JsonProperty("artist")
    private String artist;
    @JsonProperty("title")
    private String title;
    @JsonProperty("album")
    private String album;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("label")
    private String label;
    @JsonProperty("timecode")
    private String timecode;
    @JsonProperty("song_link")
    private String songLink;
    @JsonProperty("spotify")
    private Spotify spotify;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("artist")
    public String getArtist() {
        return artist;
    }

    @JsonProperty("artist")
    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Result withArtist(String artist) {
        this.artist = artist;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Result withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("album")
    public String getAlbum() {
        return album;
    }

    @JsonProperty("album")
    public void setAlbum(String album) {
        this.album = album;
    }

    public Result withAlbum(String album) {
        this.album = album;
        return this;
    }

    @JsonProperty("release_date")
    public String getReleaseDate() {
        return releaseDate;
    }

    @JsonProperty("release_date")
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Result withReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        return this;
    }

    @JsonProperty("label")
    public String getLabel() {
        return label;
    }

    @JsonProperty("label")
    public void setLabel(String label) {
        this.label = label;
    }

    public Result withLabel(String label) {
        this.label = label;
        return this;
    }

    @JsonProperty("timecode")
    public String getTimecode() {
        return timecode;
    }

    @JsonProperty("timecode")
    public void setTimecode(String timecode) {
        this.timecode = timecode;
    }

    public Result withTimecode(String timecode) {
        this.timecode = timecode;
        return this;
    }

    @JsonProperty("song_link")
    public String getSongLink() {
        return songLink;
    }

    @JsonProperty("song_link")
    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public Result withSongLink(String songLink) {
        this.songLink = songLink;
        return this;
    }

    @JsonProperty("spotify")
    public Spotify getSpotify() {
        return spotify;
    }

    @JsonProperty("spotify")
    public void setSpotify(Spotify spotify) {
        this.spotify = spotify;
    }

    public Result withSpotify(Spotify spotify) {
        this.spotify = spotify;
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

    public Result withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Result.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("artist");
        sb.append('=');
        sb.append(((this.artist == null)?"<null>":this.artist));
        sb.append(',');
        sb.append("title");
        sb.append('=');
        sb.append(((this.title == null)?"<null>":this.title));
        sb.append(',');
        sb.append("album");
        sb.append('=');
        sb.append(((this.album == null)?"<null>":this.album));
        sb.append(',');
        sb.append("releaseDate");
        sb.append('=');
        sb.append(((this.releaseDate == null)?"<null>":this.releaseDate));
        sb.append(',');
        sb.append("label");
        sb.append('=');
        sb.append(((this.label == null)?"<null>":this.label));
        sb.append(',');
        sb.append("timecode");
        sb.append('=');
        sb.append(((this.timecode == null)?"<null>":this.timecode));
        sb.append(',');
        sb.append("songLink");
        sb.append('=');
        sb.append(((this.songLink == null)?"<null>":this.songLink));
        sb.append(',');
        sb.append("spotify");
        sb.append('=');
        sb.append(((this.spotify == null)?"<null>":this.spotify));
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
        result = ((result* 31)+((this.songLink == null)? 0 :this.songLink.hashCode()));
        result = ((result* 31)+((this.artist == null)? 0 :this.artist.hashCode()));
        result = ((result* 31)+((this.releaseDate == null)? 0 :this.releaseDate.hashCode()));
        result = ((result* 31)+((this.album == null)? 0 :this.album.hashCode()));
        result = ((result* 31)+((this.spotify == null)? 0 :this.spotify.hashCode()));
        result = ((result* 31)+((this.label == null)? 0 :this.label.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.title == null)? 0 :this.title.hashCode()));
        result = ((result* 31)+((this.timecode == null)? 0 :this.timecode.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return ((((((((((this.songLink == rhs.songLink)||((this.songLink!= null)&&this.songLink.equals(rhs.songLink)))&&((this.artist == rhs.artist)||((this.artist!= null)&&this.artist.equals(rhs.artist))))&&((this.releaseDate == rhs.releaseDate)||((this.releaseDate!= null)&&this.releaseDate.equals(rhs.releaseDate))))&&((this.album == rhs.album)||((this.album!= null)&&this.album.equals(rhs.album))))&&((this.spotify == rhs.spotify)||((this.spotify!= null)&&this.spotify.equals(rhs.spotify))))&&((this.label == rhs.label)||((this.label!= null)&&this.label.equals(rhs.label))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.title == rhs.title)||((this.title!= null)&&this.title.equals(rhs.title))))&&((this.timecode == rhs.timecode)||((this.timecode!= null)&&this.timecode.equals(rhs.timecode))));
    }

}
