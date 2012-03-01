/*
 * This library is part of Geranium -
 * an open source UI library for GWT.
 *
 * Copyright (c) Alkacon Software GmbH (http://www.alkacon.com)-
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * For further information about Alkacon Software, please see the
 * company website: http://www.alkacon.com
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */

package com.alkacon.geranium.client.ui.input;

import com.google.gwt.event.logical.shared.HasValueChangeHandlers;
import com.google.gwt.event.logical.shared.ValueChangeEvent;

/**
 * This class coordinates multiple radio buttons and makes sure that when a radio button of a group is
 * selected, no other radio button of the same group is selected.<p>
 * 
 * @since 8.0.0
 */
public class RadioButtonGroup {

    /** The currently selected radio button (null if none is selected). */
    private RadioButton m_selectedButton;

    /** The object to which value change events should be fired. */
    private HasValueChangeHandlers<String> m_target;

    /** 
     * Deselects a selected radio button (if one is selected).<p>
     */
    public void deselectButton() {

        if (m_selectedButton != null) {
            if (m_selectedButton.isChecked()) {
                m_selectedButton.setChecked(false);
            }
            m_selectedButton = null;
        }
    }

    /**
     * Returns the currently selected button, or null if none is selected.<p>
     * 
     * @return the selected button or null
     */
    public RadioButton getSelectedButton() {

        return m_selectedButton;
    }

    /**
     * Selects a new button and deselects the previously selected one.<p>
     * 
     * @param button the button which should be selected 
     */
    public void selectButton(RadioButton button) {

        if (m_selectedButton != button) {
            if (m_selectedButton != null) {
                m_selectedButton.setChecked(false);
            }
            if (!button.isChecked()) {
                button.setChecked(true);
            }
            m_selectedButton = button;
            if (m_target != null) {
                ValueChangeEvent.fire(m_target, button.getName());
            }
        }
    }

    /**
     * Sets the new value change event target for this button group.<p>
     * 
     * @param target the value change event target 
     */
    public void setValueChangeTarget(HasValueChangeHandlers<String> target) {

        m_target = target;
    }

}
