package behavior.chainofresponsibility.impl;

import chainofresponsibility_责任链.Filter;
import chainofresponsibility_责任链.Request;
import chainofresponsibility_责任链.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 过滤链
 * @author Administrator
 *
 */
public class FilterChain implements Filter {
	int index = 0;
	List<Filter> filters = new ArrayList<Filter>();

	public FilterChain addFilter(Filter f) {
		this.filters.add(f);
		return this;
	}
	
	@Override
	public void doFilter(Request request, Response response,FilterChain chain) {
		if(index == filters.size()) {
			return;
		}
		Filter f = filters.get(index);
		index ++;
		f.doFilter(request, response, chain);
	}
}
