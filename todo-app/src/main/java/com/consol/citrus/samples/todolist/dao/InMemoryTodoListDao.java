/*
 * Copyright 2006-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.samples.todolist.dao;

import com.consol.citrus.samples.todolist.model.TodoEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Christoph Deppisch
 */
public class InMemoryTodoListDao implements TodoListDao {

    /** In memory storage */
    private List<TodoEntry> storage = new ArrayList<>();

    @Override
    public void save(TodoEntry entry) {
        storage.add(entry);
    }

    @Override
    public List<TodoEntry> list() {
        return storage;
    }

    @Override
    public void deleteByTitle(String title) {
        List<TodoEntry> filtered = new ArrayList<>();
        for (TodoEntry entry: storage) {
            if (!entry.getTitle().equals(title)) {
                filtered.add(entry);
            }
        }

        storage = filtered;
    }

    @Override
    public void deleteAll() {
        storage.clear();
    }
}
