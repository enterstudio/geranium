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

package com.alkacon.geranium.client.dnd;

import com.google.gwt.dom.client.Element;

/**
 * Interface defining all methods used by drag and drop on a draggable element.<p>
 * 
 * @since 8.0.0
 */
public interface I_Draggable {

    /**
     * Creates the drag helper element and attaches it into the DOM.<p>
     * 
     * @param target the drop target
     * 
     * @return the drag helper element
     */
    Element getDragHelper(I_DropTarget target);

    /**
     * Returns the draggable element.<p>
     * 
     * @return the element
     */
    Element getElement();

    /**
     * Returns the draggable id.<p>
     * 
     * @return the id
     */
    String getId();

    /**
     * Returns the parent drop target or <code>null</code> if there is none.<p>
     * 
     * @return the parent drop target
     */
    I_DropTarget getParentTarget();

    /**
     * Creates the drag placeholder element.<p>
     * 
     * @param target the drop target
     * 
     * @return the drag placeholder element
     */
    Element getPlaceholder(I_DropTarget target);

    /**
     * Checks whether the drag item has a given tag.<p>
     * 
     * @param tag the tag to check
     *  
     * @return true if the drag item has the tag 
     */
    boolean hasTag(String tag);

    /**
     * Executed on drag cancel.<p>
     */
    void onDragCancel();

    /**
     * Executed on drop.<p>
     * 
     * @param target the drop target
     */
    void onDrop(I_DropTarget target);

    /**
     * Executed on drag start.<p>
     * 
     * @param target the current drop target
     */
    void onStartDrag(I_DropTarget target);
}
