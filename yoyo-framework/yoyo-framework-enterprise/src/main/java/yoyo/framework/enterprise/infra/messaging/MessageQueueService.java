// ========================================================================
// Copyright (C) YOYO Project Team. All rights reserved.
// GNU AFFERO GENERAL PUBLIC LICENSE Version 3, 19 November 2007
// http://www.gnu.org/licenses/agpl-3.0.txt
// ========================================================================
package yoyo.framework.enterprise.infra.messaging;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
/**
 * メッセージキューサービス
 * @author nilcy
 */
@MessageDriven(mappedName = "jms/yoyo/primaryQueue", activationConfig = { @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue") })
public class MessageQueueService implements MessageListener {
    /** コンストラクタ */
    public MessageQueueService() {
    }
    /** {@inheritDoc} */
    @Override
    public void onMessage(final Message message) {
        assert message != null;
    }
}
