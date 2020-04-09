package com.hyp.config.sitemesh;

import org.sitemesh.SiteMeshContext;
import org.sitemesh.content.ContentProperty;
import org.sitemesh.content.tagrules.TagRuleBundle;
import org.sitemesh.content.tagrules.html.ExportTagToContentRule;
import org.sitemesh.tagprocessor.State;

public class ScriptTagRuleBundle implements TagRuleBundle {

    @Override
    public void install(State defaultState, ContentProperty contentProperty,
                        SiteMeshContext siteMeshContext) {
          defaultState.addRule("pms_js",
                  new ExportTagToContentRule(siteMeshContext,contentProperty.getChild("pms_js"), false));
    }

    @Override
    public void cleanUp(State defaultState, ContentProperty contentProperty,
                        SiteMeshContext siteMeshContext) {

    }

}
