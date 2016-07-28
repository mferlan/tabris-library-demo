/*******************************************************************************
 * Copyright (c) 2013 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package de.atron.books.tabris.demo.ui;

import static de.atron.books.tabris.demo.ui.BookDetailsPage.BOOK_ITEM;
import static de.atron.books.tabris.demo.ui.BookProvider.findBookTitles;
import static de.atron.books.tabris.demo.ui.BookProvider.findBooks;

import java.util.List;

import com.eclipsesource.tabris.ui.PageData;
import com.eclipsesource.tabris.ui.action.Proposal;
import com.eclipsesource.tabris.ui.action.ProposalHandler;
import com.eclipsesource.tabris.ui.action.SearchAction;

public class BookSearchAction extends SearchAction {

  @Override
  public void search( String query ) {
    List<Book> books = findBooks( getUI().getDisplay(), query );
    if( books.size() == 1 ) {
      showBookDetailsPage( books.get( 0 ) );
    } else {
      showSearchResultsPage( query );
    }
  }

  private void showBookDetailsPage( Book book ) {
    PageData data = new PageData();
    data.set( BOOK_ITEM, book );
    openPage( BookDetailsPage.class.getName(), data );
  }

  private void showSearchResultsPage( String query ) {
    if( getCurrentPage() instanceof SearchResultsPage ) {
      closeCurrentPage();
    }
    PageData data = new PageData();
    data.set( SearchResultsPage.SEARCH_QUERY, query );
    openPage( SearchResultsPage.class.getName(), data );
  }

  @Override
  public void modified( final String query, final ProposalHandler proposalHandler ) {
    // start potentially long running proposal gathering thread
    new Thread( new Runnable() {

      @Override
      public void run() {
        getUI().getDisplay().asyncExec( new Runnable() {

          @Override
          public void run() {
            // should be performed in the thread not in the async display
            final List<Proposal> bookTitles = findBookTitles( getUI().getDisplay(), query );
            proposalHandler.setProposals( bookTitles );
          }
        } );
      }
    } ).start();
  }
}