var S_URL_CMS_R='http://localhost:8080/cms_r/';
var S_URL='http://localhost:8080/wx/';
angular.module("starter.config", [])
    .constant("ENV", {
            // "name": "production",
            "debug": false,
            "categoryQueryUrl": S_URL_CMS_R+"cms_article_class/query",
            "newSlideUrl":S_URL_CMS_R+"cms_slide/new_slide",
            'articleLangUrl':S_URL_CMS_R+"article_lang/image_query",
            'articleLangPageUrl':S_URL_CMS_R+"article_lang/page",
            'version':'1.0.1'
    });
