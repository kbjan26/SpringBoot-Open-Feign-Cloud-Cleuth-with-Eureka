package com.example.springbootsleuthzipkin.config;

import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
class SleuthTraceFilter extends OncePerRequestFilter {

    private static final String TRACKING_HEADER = "X-TRACKING-ID";

    @Autowired
    private Tracer tracer;

    @Override
    protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                                    final FilterChain filterChain) throws ServletException, IOException {

        final Span currentSpan = tracer.currentSpan();
        if (null != currentSpan && StringUtils.isEmpty(response.getHeader(TRACKING_HEADER))) {

            final String traceId = currentSpan.context().traceIdString();
            response.setHeader(TRACKING_HEADER, traceId);
        }
        filterChain.doFilter(request, response);
    }
}