/*
 * Copyright (C) 2016 Talsma ICT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package nl.talsmasoftware.concurrency.context;

/**
 * @author Sjoerd Talsma
 */
public interface ContextManager<T> {

    /**
     * This method initializes a new context containing the specified <code>value</code>.
     * <p>
     * Whether the value is allowed to be <code>null</code> is up to the implementation.
     *
     * @param value The value to initialize a new context for (which should be closed by the caller at the end of its lifecycle).
     * @return The new context containing the specified value.
     */
    Context initializeNewContext(T value);

    /**
     * This method returns the current context, or <code>null</code> if no context is currently active.
     *
     * @return The active context or <code>null</code> if there is no context currently active.
     */
    Context<T> getActiveContext();

}