package com.merge.api.resources.crm.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MultipartFormFieldRequest.Builder.class)
public final class MultipartFormFieldRequest {
    private final String name;

    private final String data;

    private final Optional<MultipartFormFieldRequestEncoding> encoding;

    private final Optional<String> fileName;

    private final Optional<String> contentType;

    private MultipartFormFieldRequest(
            String name,
            String data,
            Optional<MultipartFormFieldRequestEncoding> encoding,
            Optional<String> fileName,
            Optional<String> contentType) {
        this.name = name;
        this.data = data;
        this.encoding = encoding;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    /**
     * @return The name of the form field &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * @return The data for the form field. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;
     */
    @JsonProperty("data")
    public String getData() {
        return data;
    }

    /**
     * @return The encoding of the value of <code>data</code>. Defaults to <code>RAW</code> if not defined.
     * <ul>
     * <li><code>RAW</code> - RAW</li>
     * <li><code>BASE64</code> - BASE64</li>
     * <li><code>GZIP_BASE64</code> - GZIP_BASE64</li>
     * </ul>
     */
    @JsonProperty("encoding")
    public Optional<MultipartFormFieldRequestEncoding> getEncoding() {
        return encoding;
    }

    /**
     * @return The file name of the form field, if the field is for a file.
     */
    @JsonProperty("file_name")
    public Optional<String> getFileName() {
        return fileName;
    }

    /**
     * @return The MIME type of the file, if the field is for a file.
     */
    @JsonProperty("content_type")
    public Optional<String> getContentType() {
        return contentType;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MultipartFormFieldRequest && equalTo((MultipartFormFieldRequest) other);
    }

    private boolean equalTo(MultipartFormFieldRequest other) {
        return name.equals(other.name)
                && data.equals(other.data)
                && encoding.equals(other.encoding)
                && fileName.equals(other.fileName)
                && contentType.equals(other.contentType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.data, this.encoding, this.fileName, this.contentType);
    }

    @Override
    public String toString() {
        return "MultipartFormFieldRequest{" + "name: " + name + ", data: " + data + ", encoding: " + encoding
                + ", fileName: " + fileName + ", contentType: " + contentType + "}";
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        DataStage name(String name);

        Builder from(MultipartFormFieldRequest other);
    }

    public interface DataStage {
        _FinalStage data(String data);
    }

    public interface _FinalStage {
        MultipartFormFieldRequest build();

        _FinalStage encoding(Optional<MultipartFormFieldRequestEncoding> encoding);

        _FinalStage encoding(MultipartFormFieldRequestEncoding encoding);

        _FinalStage fileName(Optional<String> fileName);

        _FinalStage fileName(String fileName);

        _FinalStage contentType(Optional<String> contentType);

        _FinalStage contentType(String contentType);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, DataStage, _FinalStage {
        private String name;

        private String data;

        private Optional<String> contentType = Optional.empty();

        private Optional<String> fileName = Optional.empty();

        private Optional<MultipartFormFieldRequestEncoding> encoding = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(MultipartFormFieldRequest other) {
            name(other.getName());
            data(other.getData());
            encoding(other.getEncoding());
            fileName(other.getFileName());
            contentType(other.getContentType());
            return this;
        }

        /**
         * <p>The name of the form field &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name")
        public DataStage name(String name) {
            this.name = name;
            return this;
        }

        /**
         * <p>The data for the form field. &lt;span style=&quot;white-space: nowrap&quot;&gt;<code>non-empty</code>&lt;/span&gt;</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("data")
        public _FinalStage data(String data) {
            this.data = data;
            return this;
        }

        /**
         * <p>The MIME type of the file, if the field is for a file.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentType(String contentType) {
            this.contentType = Optional.of(contentType);
            return this;
        }

        @Override
        @JsonSetter(value = "content_type", nulls = Nulls.SKIP)
        public _FinalStage contentType(Optional<String> contentType) {
            this.contentType = contentType;
            return this;
        }

        /**
         * <p>The file name of the form field, if the field is for a file.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage fileName(String fileName) {
            this.fileName = Optional.of(fileName);
            return this;
        }

        @Override
        @JsonSetter(value = "file_name", nulls = Nulls.SKIP)
        public _FinalStage fileName(Optional<String> fileName) {
            this.fileName = fileName;
            return this;
        }

        /**
         * <p>The encoding of the value of <code>data</code>. Defaults to <code>RAW</code> if not defined.</p>
         * <ul>
         * <li><code>RAW</code> - RAW</li>
         * <li><code>BASE64</code> - BASE64</li>
         * <li><code>GZIP_BASE64</code> - GZIP_BASE64</li>
         * </ul>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage encoding(MultipartFormFieldRequestEncoding encoding) {
            this.encoding = Optional.of(encoding);
            return this;
        }

        @Override
        @JsonSetter(value = "encoding", nulls = Nulls.SKIP)
        public _FinalStage encoding(Optional<MultipartFormFieldRequestEncoding> encoding) {
            this.encoding = encoding;
            return this;
        }

        @Override
        public MultipartFormFieldRequest build() {
            return new MultipartFormFieldRequest(name, data, encoding, fileName, contentType);
        }
    }
}
