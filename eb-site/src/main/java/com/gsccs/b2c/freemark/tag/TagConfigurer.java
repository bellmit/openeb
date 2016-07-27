package com.gsccs.b2c.freemark.tag;

import java.io.IOException;

import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.gsccs.b2c.shiro.tag.ShiroTags;

import freemarker.template.TemplateException;

public class TagConfigurer extends FreeMarkerConfigurer {

	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		super.afterPropertiesSet();
		this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
		//this.getConfiguration().setSharedVariable("b2c", new B2cTags());
	}

}
