// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.actor.service.domain;
import java.math.BigDecimal;
import java.util.logging.Logger;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.apache.commons.lang3.StringUtils;
import yoyo.actor.service.domain.Member;
import yoyo.actor.service.domain.MemberFilter;
import yoyo.actor.service.domain.Member_;
import yoyo.actor.service.domain.PersistenceServiceAnnotation.MemberPersistenceService;
import yoyo.framework.enterprise.domain.AbstractQueryRepositoryImpl;
import yoyo.framework.enterprise.infra.logging.TraceLogger;
import yoyo.framework.enterprise.infra.persistence.QueryPersistenceService;
/**
 * Member repository implementation.
 * @author nilcy
 */
@Default
@TraceLogger
public class MemberRepositoryImpl extends
    AbstractQueryRepositoryImpl<Member, BigDecimal, MemberFilter> implements MemberRepository {
    /** 製品番号 */
    private static final long serialVersionUID = 2537651945740718957L;
    /** 先進データ永続化サービス */
    @Inject
    @MemberPersistenceService
    private QueryPersistenceService<Member, BigDecimal> service;
    /** {@inheritDoc} */
    @Override
    protected QueryPersistenceService<Member, BigDecimal> getPersistenceService() {
        return service;
    }
    /**
     * {@inheritDoc}
     * <dl>
     * <dt>事前条件</dt>
     * <dd>フィルタは非NULLであること。</dd>
     * <dt>事後条件</dt>
     * <dd>指定したアカウントで検索条件とする。</dd>
     * </dl>
     */
    @Override
    protected Predicate expression(final MemberFilter filter) {
        Logger.getGlobal().info("filter = " + filter);
        assert filter != null;
        if (StringUtils.isEmpty(filter.getAccount())) {
            return super.expression(filter);
        }
        final CriteriaBuilder b = service.builder();
        final Root<Member> r = service.root();
        return b.equal(r.get(Member_.account), filter.getAccount());
    }
}
