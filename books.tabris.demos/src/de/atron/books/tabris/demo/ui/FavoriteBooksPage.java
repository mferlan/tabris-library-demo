/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    EclipseSource - initial API and implementation
 ******************************************************************************/
package de.atron.books.tabris.demo.ui;

import java.util.ArrayList;
import java.util.List;

public class FavoriteBooksPage extends BooksListPage {

  private static class FavoriteBookFilter implements BookFilter {

    @Override
    public List<Book> filter( List<Book> books ) {
      List<Book> result = new ArrayList<Book>();
      for( Book book : books ) {
        if( book.isPopular() ) {
          result.add( book );
        }
      }
      return result;
    }
  }

  public FavoriteBooksPage() {
    setBookFilter( new FavoriteBookFilter() );
  }
}
