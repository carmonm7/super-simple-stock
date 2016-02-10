package com.sss.app.arch;

import com.sss.app.arch.impl.SpringServiceImpl;

/**
 * Spring service which give access in a dynamic way to all classes and services
 * configured in the Spring context.
 * 
 */
public interface SpringService {
	/**
	 * Singleton instance of the SpringService.
	 */
	SpringService INSTANCE = SpringServiceImpl.getInstance();

	/**
	 * Gets an object of the bean configured in the Spring context with the name
	 * <i>beanName</i> and representing for the class <i>objectClass</i>.
	 * 
	 * @param beanName
	 *            The id for the bean in the Spring context.
	 * @param objectClass
	 *            The class of the bean configured with the name <i>beanName</i>
	 *            in the Spring context.
	 * 
	 * @return Return an object corresponding to the bean configured in the
	 *         Spring context with the name <i>beanName</i> and represented for
	 *         the class <i>objectClass</i>.
	 */
	<T extends Object> T getBean(String beanName, Class<T> objectClass);

	/**
	 * Gets an object of the bean configured in the Spring context for the class
	 * <i>objectClass</i>.
	 * 
	 * @param objectClass
	 *            The class of the bean configured in the Spring context.
	 * 
	 * @return Return an object corresponding to the bean configured in the
	 *         Spring context represented for the class <i>objectClass</i>.
	 */
	<T extends Object> T getBean(Class<T> objectClass);

}
