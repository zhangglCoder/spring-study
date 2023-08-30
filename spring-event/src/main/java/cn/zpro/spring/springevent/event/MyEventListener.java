/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.zpro.spring.springevent.event;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.AliasFor;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalApplicationListener;
import org.springframework.transaction.event.TransactionalApplicationListenerMethodAdapter;

import java.lang.annotation.*;

/**
 * An {@link EventListener} that is invoked according to a {@link TransactionPhase}.
 * This is an annotation-based equivalent of {@link TransactionalApplicationListener}.
 *
 * <p>If the event is not published within an active transaction, the event is discarded
 * unless the {@link #fallbackExecution} flag is explicitly set. If a transaction is
 * running, the event is handled according to its {@code TransactionPhase}.
 *
 * <p>Adding {@link org.springframework.core.annotation.Order @Order} to your annotated
 * method allows you to prioritize that listener amongst other listeners running before
 * or after transaction completion.
 *
 * <p><b>NOTE: Transactional event listeners only work with thread-bound transactions
 * managed by a {@link org.springframework.transaction.PlatformTransactionManager
 * PlatformTransactionManager}.</b> A reactive transaction managed by a
 * {@link org.springframework.transaction.ReactiveTransactionManager ReactiveTransactionManager}
 * uses the Reactor context instead of thread-local variables, so from the perspective of
 * an event listener, there is no compatible active transaction that it can participate in.
 *
 * <p><strong>WARNING:</strong> if the {@code TransactionPhase} is set to
 * {@link TransactionPhase#AFTER_COMMIT AFTER_COMMIT} (the default),
 * {@link TransactionPhase#AFTER_ROLLBACK AFTER_ROLLBACK}, or
 * {@link TransactionPhase#AFTER_COMPLETION AFTER_COMPLETION}, the transaction will
 * have been committed or rolled back already, but the transactional resources might
 * still be active and accessible. As a consequence, any data access code triggered
 * at this point will still "participate" in the original transaction, but changes
 * will not be committed to the transactional resource. See
 * {@link org.springframework.transaction.support.TransactionSynchronization#afterCompletion(int)
 * TransactionSynchronization.afterCompletion(int)} for details.
 *
 * @author Stephane Nicoll
 * @author Sam Brannen
 * @author Oliver Drotbohm
 * @since 4.2
 * @see TransactionalApplicationListener
 * @see TransactionalApplicationListenerMethodAdapter
 */
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EventListener
public @interface MyEventListener {

	/**
	 * 自定义
	 * @return
	 */
	String name() default "";

	/**
	 * Alias for {@link #classes}.
	 */
	@AliasFor(annotation = EventListener.class, attribute = "classes")
	Class<?>[] value() default {};

	/**
	 * The event classes that this listener handles.
	 * <p>If this attribute is specified with a single value, the annotated
	 * method may optionally accept a single parameter. However, if this
	 * attribute is specified with multiple values, the annotated method
	 * must <em>not</em> declare any parameters.
	 */
	@AliasFor(annotation = EventListener.class, attribute = "classes")
	Class<?>[] classes() default {};

	/**
	 * Spring Expression Language (SpEL) attribute used for making the event
	 * handling conditional.
	 * <p>The default is {@code ""}, meaning the event is always handled.
	 * @see EventListener#condition
	 */
	@AliasFor(annotation = EventListener.class, attribute = "condition")
	String condition() default "";

	/**
	 * An optional identifier for the listener, defaulting to the fully-qualified
	 * signature of the declaring method (e.g. "mypackage.MyClass.myMethod()").
	 * @since 5.3
	 * @see EventListener#id
	 * @see TransactionalApplicationListener#getListenerId()
	 */
	@AliasFor(annotation = EventListener.class, attribute = "id")
	String id() default "";

}
