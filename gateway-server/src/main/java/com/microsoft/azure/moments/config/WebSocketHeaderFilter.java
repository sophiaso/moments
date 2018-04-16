package com.microsoft.azure.moments.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebSocketHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        RequestWrapper wrapper = new RequestWrapper(ctx.getRequest());
        String upgradeHeader = wrapper.getHeader("Upgrade");
        if (null == upgradeHeader) {
            upgradeHeader = wrapper.getHeader("upgrade");
        }
        if (null != upgradeHeader && "websocket".equalsIgnoreCase(upgradeHeader)) {
            wrapper.addHeader("connection", "Upgrade");
            ctx.addZuulRequestHeader("connection", "Upgrade");
            ctx.setRequest(wrapper);
        }
        return null;
    }
}
