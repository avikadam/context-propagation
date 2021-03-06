/*
 * Copyright 2016-2017 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package nl.talsmasoftware.context;

/**
 * This interface defines the contract for a ContextManager Service.
 * <p>
 * Concrete implementations can be registered by providing an implementation class with a default constructor,
 * along with a class declaration in a service file called:<br>
 * <code>"/META-INF/services/nl.talsmasoftware.context.ContextManager"</code>
 * <p>
 * That will take care of any active context being captured in {@link ContextSnapshot} instances
 * managed by the {@link ContextManagers} utility class.
 * <p>
 * <center><img src="ContextManager.svg" alt="Context manager interface"></center>
 *
 * @author Sjoerd Talsma
 */
public interface ContextManager<T> {

    /**
     * This method initializes a new context containing the specified <code>value</code>.
     * <p>
     * Whether the value is allowed to be <code>null</code> is up to the implementation.
     *
     * @param value The value to initialize a new context for
     *              (which should be closed by the caller at the end of its lifecycle).
     * @return The new <em>active</em> context containing the specified value.
     */
    Context<T> initializeNewContext(T value);

    /**
     * This method returns the current context, or <code>null</code> if no context is currently active.
     *
     * @return The active context or <code>null</code> if there is no context currently active.
     */
    Context<T> getActiveContext();

}
