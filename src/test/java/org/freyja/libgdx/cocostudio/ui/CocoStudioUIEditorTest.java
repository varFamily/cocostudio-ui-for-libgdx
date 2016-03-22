/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.freyja.libgdx.cocostudio.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import org.freyja.libgdx.cocostudio.ui.junit.LibgdxRunner;
import org.freyja.libgdx.cocostudio.ui.junit.NeedGL;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.internal.util.reflection.Whitebox;

import java.io.File;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(LibgdxRunner.class)
public class CocoStudioUIEditorTest {

    @Test
    @NeedGL
    public void shouldGetAllParsers() throws Exception {
        FileHandle defaultFont = Gdx.files.internal("share/MLFZS.ttf");

        CocoStudioUIEditor editor = new CocoStudioUIEditor(
            Gdx.files.internal("single-button/MainScene.json"), null, null, defaultFont, null);
        assertThat(editor.getDirName(), is("single-button" + File.separator));

        Map<String, BaseWidgetParser> parsers = (Map<String, BaseWidgetParser>) Whitebox.getInternalState(editor, "parsers");

        assertThat(parsers.size(), is(16));
    }
}