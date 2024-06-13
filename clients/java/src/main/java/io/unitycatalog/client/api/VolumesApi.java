/*
 * Unity Catalog API
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: 0.1
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package io.unitycatalog.client.api;

import io.unitycatalog.client.ApiClient;
import io.unitycatalog.client.ApiException;
import io.unitycatalog.client.ApiResponse;
import io.unitycatalog.client.Pair;

import io.unitycatalog.client.model.CreateVolumeRequestContent;
import io.unitycatalog.client.model.ListVolumesResponseContent;
import io.unitycatalog.client.model.UpdateVolumeRequestContent;
import io.unitycatalog.client.model.VolumeInfo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.http.HttpRequest;
import java.nio.channels.Channels;
import java.nio.channels.Pipe;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import java.util.ArrayList;
import java.util.StringJoiner;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", comments = "Generator version: 7.5.0")
public class VolumesApi {
  private final HttpClient memberVarHttpClient;
  private final ObjectMapper memberVarObjectMapper;
  private final String memberVarBaseUri;
  private final Consumer<HttpRequest.Builder> memberVarInterceptor;
  private final Duration memberVarReadTimeout;
  private final Consumer<HttpResponse<InputStream>> memberVarResponseInterceptor;
  private final Consumer<HttpResponse<String>> memberVarAsyncResponseInterceptor;

  public VolumesApi() {
    this(new ApiClient());
  }

  public VolumesApi(ApiClient apiClient) {
    memberVarHttpClient = apiClient.getHttpClient();
    memberVarObjectMapper = apiClient.getObjectMapper();
    memberVarBaseUri = apiClient.getBaseUri();
    memberVarInterceptor = apiClient.getRequestInterceptor();
    memberVarReadTimeout = apiClient.getReadTimeout();
    memberVarResponseInterceptor = apiClient.getResponseInterceptor();
    memberVarAsyncResponseInterceptor = apiClient.getAsyncResponseInterceptor();
  }

  protected ApiException getApiException(String operationId, HttpResponse<InputStream> response) throws IOException {
    String body = response.body() == null ? null : new String(response.body().readAllBytes());
    String message = formatExceptionMessage(operationId, response.statusCode(), body);
    return new ApiException(response.statusCode(), message, response.headers(), body);
  }

  private String formatExceptionMessage(String operationId, int statusCode, String body) {
    if (body == null || body.isEmpty()) {
      body = "[no body]";
    }
    return operationId + " call failed with: " + statusCode + " - " + body;
  }

  /**
   * Create a Volume
   * Creates a new volume. 
   * @param createVolumeRequestContent  (required)
   * @return VolumeInfo
   * @throws ApiException if fails to make API call
   */
  public VolumeInfo createVolume(CreateVolumeRequestContent createVolumeRequestContent) throws ApiException {
    ApiResponse<VolumeInfo> localVarResponse = createVolumeWithHttpInfo(createVolumeRequestContent);
    return localVarResponse.getData();
  }

  /**
   * Create a Volume
   * Creates a new volume. 
   * @param createVolumeRequestContent  (required)
   * @return ApiResponse&lt;VolumeInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<VolumeInfo> createVolumeWithHttpInfo(CreateVolumeRequestContent createVolumeRequestContent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = createVolumeRequestBuilder(createVolumeRequestContent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("createVolume", localVarResponse);
        }
        return new ApiResponse<VolumeInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<VolumeInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder createVolumeRequestBuilder(CreateVolumeRequestContent createVolumeRequestContent) throws ApiException {
    // verify the required parameter 'createVolumeRequestContent' is set
    if (createVolumeRequestContent == null) {
      throw new ApiException(400, "Missing the required parameter 'createVolumeRequestContent' when calling createVolume");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/volumes";

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(createVolumeRequestContent);
      localVarRequestBuilder.method("POST", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Delete a Volume
   * Deletes a volume from the specified parent catalog and schema. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @return Object
   * @throws ApiException if fails to make API call
   */
  public Object deleteVolume(String name) throws ApiException {
    ApiResponse<Object> localVarResponse = deleteVolumeWithHttpInfo(name);
    return localVarResponse.getData();
  }

  /**
   * Delete a Volume
   * Deletes a volume from the specified parent catalog and schema. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @return ApiResponse&lt;Object&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<Object> deleteVolumeWithHttpInfo(String name) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = deleteVolumeRequestBuilder(name);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("deleteVolume", localVarResponse);
        }
        return new ApiResponse<Object>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<Object>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder deleteVolumeRequestBuilder(String name) throws ApiException {
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling deleteVolume");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/volumes/{name}"
        .replace("{name}", ApiClient.urlEncode(name.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("DELETE", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Get a Volume
   * Gets a volume for a specific catalog and schema. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @return VolumeInfo
   * @throws ApiException if fails to make API call
   */
  public VolumeInfo getVolume(String name) throws ApiException {
    ApiResponse<VolumeInfo> localVarResponse = getVolumeWithHttpInfo(name);
    return localVarResponse.getData();
  }

  /**
   * Get a Volume
   * Gets a volume for a specific catalog and schema. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @return ApiResponse&lt;VolumeInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<VolumeInfo> getVolumeWithHttpInfo(String name) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = getVolumeRequestBuilder(name);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("getVolume", localVarResponse);
        }
        return new ApiResponse<VolumeInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<VolumeInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder getVolumeRequestBuilder(String name) throws ApiException {
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling getVolume");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/volumes/{name}"
        .replace("{name}", ApiClient.urlEncode(name.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * List Volumes
   * Gets an array of available volumes under the parent catalog and schema. There is no guarantee of a specific ordering of the elements in the array. 
   * @param catalogName The identifier of the catalog (required)
   * @param schemaName The identifier of the schema (required)
   * @param maxResults Maximum number of volumes to return (page length).  If not set, the page length is set to a server configured value. - when set to a value greater than 0, the page length is the minimum of this value and a server configured value; - when set to 0, the page length is set to a server configured value; - when set to a value less than 0, an invalid parameter error is returned;  Note: this parameter controls only the maximum number of volumes to return. The actual number of volumes returned in a page may be smaller than this value, including 0, even if there are more pages.   (optional)
   * @param pageToken Opaque token returned by a previous request. It must be included in the request to retrieve the next page of results (pagination). (optional)
   * @return ListVolumesResponseContent
   * @throws ApiException if fails to make API call
   */
  public ListVolumesResponseContent listVolumes(String catalogName, String schemaName, Integer maxResults, String pageToken) throws ApiException {
    ApiResponse<ListVolumesResponseContent> localVarResponse = listVolumesWithHttpInfo(catalogName, schemaName, maxResults, pageToken);
    return localVarResponse.getData();
  }

  /**
   * List Volumes
   * Gets an array of available volumes under the parent catalog and schema. There is no guarantee of a specific ordering of the elements in the array. 
   * @param catalogName The identifier of the catalog (required)
   * @param schemaName The identifier of the schema (required)
   * @param maxResults Maximum number of volumes to return (page length).  If not set, the page length is set to a server configured value. - when set to a value greater than 0, the page length is the minimum of this value and a server configured value; - when set to 0, the page length is set to a server configured value; - when set to a value less than 0, an invalid parameter error is returned;  Note: this parameter controls only the maximum number of volumes to return. The actual number of volumes returned in a page may be smaller than this value, including 0, even if there are more pages.   (optional)
   * @param pageToken Opaque token returned by a previous request. It must be included in the request to retrieve the next page of results (pagination). (optional)
   * @return ApiResponse&lt;ListVolumesResponseContent&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<ListVolumesResponseContent> listVolumesWithHttpInfo(String catalogName, String schemaName, Integer maxResults, String pageToken) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = listVolumesRequestBuilder(catalogName, schemaName, maxResults, pageToken);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("listVolumes", localVarResponse);
        }
        return new ApiResponse<ListVolumesResponseContent>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<ListVolumesResponseContent>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder listVolumesRequestBuilder(String catalogName, String schemaName, Integer maxResults, String pageToken) throws ApiException {
    // verify the required parameter 'catalogName' is set
    if (catalogName == null) {
      throw new ApiException(400, "Missing the required parameter 'catalogName' when calling listVolumes");
    }
    // verify the required parameter 'schemaName' is set
    if (schemaName == null) {
      throw new ApiException(400, "Missing the required parameter 'schemaName' when calling listVolumes");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/volumes";

    List<Pair> localVarQueryParams = new ArrayList<>();
    StringJoiner localVarQueryStringJoiner = new StringJoiner("&");
    String localVarQueryParameterBaseName;
    localVarQueryParameterBaseName = "catalog_name";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("catalog_name", catalogName));
    localVarQueryParameterBaseName = "schema_name";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("schema_name", schemaName));
    localVarQueryParameterBaseName = "max_results";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("max_results", maxResults));
    localVarQueryParameterBaseName = "page_token";
    localVarQueryParams.addAll(ApiClient.parameterToPairs("page_token", pageToken));

    if (!localVarQueryParams.isEmpty() || localVarQueryStringJoiner.length() != 0) {
      StringJoiner queryJoiner = new StringJoiner("&");
      localVarQueryParams.forEach(p -> queryJoiner.add(p.getName() + '=' + p.getValue()));
      if (localVarQueryStringJoiner.length() != 0) {
        queryJoiner.add(localVarQueryStringJoiner.toString());
      }
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath + '?' + queryJoiner.toString()));
    } else {
      localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));
    }

    localVarRequestBuilder.header("Accept", "application/json");

    localVarRequestBuilder.method("GET", HttpRequest.BodyPublishers.noBody());
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

  /**
   * Update a Volume
   * Updates the specified volume under the specified parent catalog and schema.  Currently only the name or the comment of the volume could be updated. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @param updateVolumeRequestContent  (optional)
   * @return VolumeInfo
   * @throws ApiException if fails to make API call
   */
  public VolumeInfo updateVolume(String name, UpdateVolumeRequestContent updateVolumeRequestContent) throws ApiException {
    ApiResponse<VolumeInfo> localVarResponse = updateVolumeWithHttpInfo(name, updateVolumeRequestContent);
    return localVarResponse.getData();
  }

  /**
   * Update a Volume
   * Updates the specified volume under the specified parent catalog and schema.  Currently only the name or the comment of the volume could be updated. 
   * @param name The three-level (fully qualified) name of the volume (required)
   * @param updateVolumeRequestContent  (optional)
   * @return ApiResponse&lt;VolumeInfo&gt;
   * @throws ApiException if fails to make API call
   */
  public ApiResponse<VolumeInfo> updateVolumeWithHttpInfo(String name, UpdateVolumeRequestContent updateVolumeRequestContent) throws ApiException {
    HttpRequest.Builder localVarRequestBuilder = updateVolumeRequestBuilder(name, updateVolumeRequestContent);
    try {
      HttpResponse<InputStream> localVarResponse = memberVarHttpClient.send(
          localVarRequestBuilder.build(),
          HttpResponse.BodyHandlers.ofInputStream());
      if (memberVarResponseInterceptor != null) {
        memberVarResponseInterceptor.accept(localVarResponse);
      }
      try {
        if (localVarResponse.statusCode()/ 100 != 2) {
          throw getApiException("updateVolume", localVarResponse);
        }
        return new ApiResponse<VolumeInfo>(
          localVarResponse.statusCode(),
          localVarResponse.headers().map(),
          localVarResponse.body() == null ? null : memberVarObjectMapper.readValue(localVarResponse.body(), new TypeReference<VolumeInfo>() {}) // closes the InputStream
        );
      } finally {
      }
    } catch (IOException e) {
      throw new ApiException(e);
    }
    catch (InterruptedException e) {
      Thread.currentThread().interrupt();
      throw new ApiException(e);
    }
  }

  private HttpRequest.Builder updateVolumeRequestBuilder(String name, UpdateVolumeRequestContent updateVolumeRequestContent) throws ApiException {
    // verify the required parameter 'name' is set
    if (name == null) {
      throw new ApiException(400, "Missing the required parameter 'name' when calling updateVolume");
    }

    HttpRequest.Builder localVarRequestBuilder = HttpRequest.newBuilder();

    String localVarPath = "/volumes/{name}"
        .replace("{name}", ApiClient.urlEncode(name.toString()));

    localVarRequestBuilder.uri(URI.create(memberVarBaseUri + localVarPath));

    localVarRequestBuilder.header("Content-Type", "application/json");
    localVarRequestBuilder.header("Accept", "application/json");

    try {
      byte[] localVarPostBody = memberVarObjectMapper.writeValueAsBytes(updateVolumeRequestContent);
      localVarRequestBuilder.method("PATCH", HttpRequest.BodyPublishers.ofByteArray(localVarPostBody));
    } catch (IOException e) {
      throw new ApiException(e);
    }
    if (memberVarReadTimeout != null) {
      localVarRequestBuilder.timeout(memberVarReadTimeout);
    }
    if (memberVarInterceptor != null) {
      memberVarInterceptor.accept(localVarRequestBuilder);
    }
    return localVarRequestBuilder;
  }

}