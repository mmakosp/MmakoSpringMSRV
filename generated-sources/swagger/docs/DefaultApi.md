# DefaultApi

All URIs are relative to *https://covid-19-statistics.p.rapidapi.com*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getProvinces**](DefaultApi.md#getProvinces) | **GET** /provinces | Get provinces
[**getRegions**](DefaultApi.md#getRegions) | **GET** /regions | Get regions


<a name="getProvinces"></a>
# **getProvinces**
> InlineResponse2001 getProvinces(iso, page, size)

Get provinces

List of provinces for region.

### Example
```java
// Import classes:
//import com.mmakomsrv.invoker.ApiClient;
//import com.mmakomsrv.invoker.ApiException;
//import com.mmakomsrv.invoker.Configuration;
//import com.mmakomsrv.invoker.auth.*;
//import com.mmakomsrv.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
String iso = "iso_example"; // String | ISO code for a region
Integer page = 56; // Integer | 
Integer size = 56; // Integer | 
try {
    InlineResponse2001 result = apiInstance.getProvinces(iso, page, size);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getProvinces");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **iso** | **String**| ISO code for a region |
 **page** | **Integer**|  | [optional]
 **size** | **Integer**|  | [optional]

### Return type

[**InlineResponse2001**](InlineResponse2001.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getRegions"></a>
# **getRegions**
> InlineResponse200 getRegions(page, size)

Get regions

Retrieve a list of regions.

### Example
```java
// Import classes:
//import com.mmakomsrv.invoker.ApiClient;
//import com.mmakomsrv.invoker.ApiException;
//import com.mmakomsrv.invoker.Configuration;
//import com.mmakomsrv.invoker.auth.*;
//import com.mmakomsrv.api.DefaultApi;

ApiClient defaultClient = Configuration.getDefaultApiClient();

// Configure API key authorization: api_key
ApiKeyAuth api_key = (ApiKeyAuth) defaultClient.getAuthentication("api_key");
api_key.setApiKey("YOUR API KEY");
// Uncomment the following line to set a prefix for the API key, e.g. "Token" (defaults to null)
//api_key.setApiKeyPrefix("Token");

DefaultApi apiInstance = new DefaultApi();
Integer page = 56; // Integer | 
Integer size = 56; // Integer | 
try {
    InlineResponse200 result = apiInstance.getRegions(page, size);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#getRegions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **page** | **Integer**|  | [optional]
 **size** | **Integer**|  | [optional]

### Return type

[**InlineResponse200**](InlineResponse200.md)

### Authorization

[api_key](../README.md#api_key)

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

