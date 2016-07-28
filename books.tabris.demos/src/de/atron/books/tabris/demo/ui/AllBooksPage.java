/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package de.atron.books.tabris.demo.ui;

import java.util.List;

public class AllBooksPage extends BooksListPage {

  private static class AllBookFilter implements BookFilter {

    public List<Book> filter( List<Book> books ) {
      return books;
    }
  }

  public AllBooksPage() {
    setBookFilter( new AllBookFilter() );
  }

}
