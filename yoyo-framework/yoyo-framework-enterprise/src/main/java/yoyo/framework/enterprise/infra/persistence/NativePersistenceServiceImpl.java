// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.persistence;
import java.io.Serializable;
import javax.enterprise.inject.Default;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import yoyo.framework.enterprise.shared.Persistable;
/**
 * 原始データ永続化サービス(JPA2/NativeQuery)
 * <ol>
 * <li>{@link SimplePersistenceServiceImpl} へDB固有クエリ(SQL)を追加したサービスである。</li>
 * </ol>
 * <dl>
 * <dt>不変条件</dt>
 * <dd>なし</dd>
 * </dl>
 * @param <E> エンティティ型
 * @param <ID> 識別子オブジェクト型
 * @since JPA 1.0
 * @author nilcy
 */
@Default
public class NativePersistenceServiceImpl<E extends Persistable<ID>, ID extends Serializable>
    extends SimplePersistenceServiceImpl<E, ID> implements NativePersistenceService<E, ID> {
    /** 識別番号 */
    private static final long serialVersionUID = -1029454631523751121L;
    /**
     * コンストラクタ
     * @param manager エンティティマネージャ
     * @param clazz エンティティクラス
     */
    public NativePersistenceServiceImpl(final EntityManager manager, final Class<E> clazz) {
        super(manager, clazz);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link EntityManager#createNativeQuery(String)}へ委譲する。</li>
     * </ol>
     */
    @Override
    public Query createNativeQuery(final String sql) {
        return manager.createNativeQuery(sql);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link EntityManager#createNativeQuery(String, Class)}へ委譲する。</li>
     * </ol>
     */
    @Override
    public Query createNativeQuery(final String sql, final Class<?> resultClass) {
        return manager.createNativeQuery(sql, resultClass);
    }
    /**
     * {@inheritDoc}
     * <ol>
     * <li>{@link EntityManager#createNativeQuery(String, String)}へ委譲する。</li>
     * </ol>
     */
    @Override
    public Query createNativeQuery(final String sql, final String resultSetMappingName) {
        return manager.createNativeQuery(sql, resultSetMappingName);
    }
}
