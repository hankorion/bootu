package com.durain.bootu.model;

public class LanguageTranslation {
    private Integer id;

    private String languageKey;

    private String languageCode;

    private String languageText;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageKey() {
        return languageKey;
    }

    public void setLanguageKey(String languageKey) {
        this.languageKey = languageKey == null ? null : languageKey.trim();
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode == null ? null : languageCode.trim();
    }

    public String getLanguageText() {
        return languageText;
    }

    public void setLanguageText(String languageText) {
        this.languageText = languageText == null ? null : languageText.trim();
    }

	@Override
	public String toString() {
		return "LanguageTranslation [id=" + id + ", languageKey=" + languageKey + ", languageCode=" + languageCode
				+ ", languageText=" + languageText + "]";
	}
    
    
}