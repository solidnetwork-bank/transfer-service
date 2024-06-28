package xyz.solidnetwork.service;

import java.io.IOException;

import org.slf4j.MDC;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.lang.NonNull;

public class HeaderHttpRequestInterceptor implements ClientHttpRequestInterceptor {

  @Override
  public ClientHttpResponse intercept(@NonNull HttpRequest request, @NonNull byte[] body,
      @NonNull ClientHttpRequestExecution execution) throws IOException {
    HttpHeaders headers = request.getHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(Const.USER_ID, MDC.get(Const.USER_ID));
    headers.set(Const.TRACE_ID, MDC.get(Const.TRACE_ID));

    return execution.execute(request, body);

  }
}