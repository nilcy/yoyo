// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.screen.iface.jsf.converter;
import javax.faces.convert.FacesConverter;
import yoyo.actor.service.domain.misc.IndustryClass;
/**
 * Industry classification converter.
 * @author nilcy
 */
@FacesConverter(value = "industryClassConverter", forClass = IndustryClass.class)
public final class IndustryClassConverter extends AbstractEntityConverter {
    /** コンストラクタ */
    public IndustryClassConverter() {
        super("industryClassAction");
    }
}
