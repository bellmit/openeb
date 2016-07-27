package com.gsccs.b2c.freemark.tag;

import freemarker.template.SimpleHash;


public class B2cTags extends SimpleHash {
	
    public B2cTags() {
        put("store", new StoreTag());
    }
}