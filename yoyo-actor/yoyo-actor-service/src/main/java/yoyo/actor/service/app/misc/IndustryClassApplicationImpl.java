// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.app.misc;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;
import yoyo.actor.service.app.misc.IndustryClassApplication;
import yoyo.actor.service.domain.misc.IndustryClass;
import yoyo.actor.service.domain.misc.IndustryClassRepository;
import yoyo.framework.enterprise.app.AbstractSimpleRepositoryApplication;
import yoyo.framework.enterprise.domain.SimpleRepository;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.standard.shared.SimpleFilter;
/**
 * 業種アプリケーション
 * @author nilcy
 */
@Stateless
// @Default
@TraceLogger
public class IndustryClassApplicationImpl extends
    AbstractSimpleRepositoryApplication<IndustryClass, BigDecimal, SimpleFilter> implements
    IndustryClassApplication {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 業種リポジトリ */
    @Inject
    private IndustryClassRepository repository;
    /** コンストラクタ */
    public IndustryClassApplicationImpl() {
    }
    /** {@inheritDoc} */
    @Override
    protected SimpleRepository<IndustryClass, BigDecimal, SimpleFilter> getRepository() {
        return repository;
    }
}
