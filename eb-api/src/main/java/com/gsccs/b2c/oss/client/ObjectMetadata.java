package com.gsccs.b2c.oss.client;

public class ObjectMetadata {

	private String domain;
	private String site;
	private String path;
	private byte[] content;
	private Long contentLength;
	private String contentType;
	private ExtensionType type = ExtensionType.jpg;

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		if (null != domain && domain.trim().length() > 0) {
			if (domain.trim().endsWith("/")) {
				domain = domain.trim().substring(0, domain.trim().length() - 1);
			}
		}
		this.domain = domain;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		if (null != path && path.trim().length() > 0) {
			if (!path.trim().startsWith("/")) {
				path = "/" + path.trim();
			}
			if (!path.trim().endsWith("/")) {
				path = path.trim() + "/";
			}
		}
		this.path = path;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public Long getContentLength() {
		return contentLength;
	}

	public void setContentLength(Long contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public ExtensionType getType() {
		return type;
	}

	public void setType(ExtensionType type) {
		this.type = type;
	}

	public static enum ExtensionType {
		jpg(".jpg"), png(".png"), bpm(".bmp"), gif(".gif");

		private final String type;

		private ExtensionType(String type) {
			this.type = type;
		}

		public String getType() {
			return type;
		}
	}

}
