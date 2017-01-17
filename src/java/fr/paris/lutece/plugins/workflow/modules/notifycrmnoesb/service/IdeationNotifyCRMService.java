/*
 * Copyright (c) 2002-2014, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */

package fr.paris.lutece.plugins.workflow.modules.notifycrmnoesb.service;

import fr.paris.lutece.plugins.ideation.business.Idee;
import fr.paris.lutece.plugins.ideation.business.IdeeHome;
import fr.paris.lutece.portal.service.prefs.UserPreferencesService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IdeationNotifyCRMService implements INotifyCRMService
{
    private static final String MARK_PSEUDO = "pseudo";
    private static final String MARK_IDEA_TITLE = "titre_idee";
    private static final String MARK_IDEA_CREATION_DATE = "date_depot_idee";
    private static final String MARK_IDEA_REFERENCE = "idee_reference";
    private static final String MARK_IDEA_MOTIF_RECEIV = "motif_receiv";
    private static final String MARK_IDEA_ID_PROJECT = "id_projet";
    private static final String MARK_IDEA_TITLE_PROJECT = "titre_projet";
    private static final String MARK_IDEA_URL_PROJECT = "url_projet";
    
     /**
     * {@inheritDoc}
     */
    @Override
    public List<String> getListMarkers( )
    {
        List<String> listMarkers = new ArrayList();
        listMarkers.add( MARK_PSEUDO );
        listMarkers.add( MARK_IDEA_TITLE );
        listMarkers.add( MARK_IDEA_CREATION_DATE );
        listMarkers.add( MARK_IDEA_REFERENCE );
        listMarkers.add( MARK_IDEA_MOTIF_RECEIV );
        listMarkers.add( MARK_IDEA_ID_PROJECT );
        listMarkers.add( MARK_IDEA_TITLE_PROJECT );
        listMarkers.add( MARK_IDEA_URL_PROJECT );
        return listMarkers;
    }
    
     /**
     * {@inheritDoc}
     */
    @Override
    public Map<String,Object> fillModelInfoResource( int nIdRessource )
    {
        Idee idee = IdeeHome.findByPrimaryKey( nIdRessource );
        Map<String,Object> model = new HashMap<String,Object>();
        model.put( MARK_PSEUDO, UserPreferencesService.instance( ).getNickname( idee.getLuteceUserName( ) ) );
        model.put( MARK_IDEA_TITLE , idee.getTitre( ) );
        model.put( MARK_IDEA_CREATION_DATE, idee.getCreationTimestamp( ) );
        model.put( MARK_IDEA_REFERENCE, idee.getReference( ) );
        model.put( MARK_IDEA_MOTIF_RECEIV, idee.getMotifRecev( ) );
        model.put( MARK_IDEA_ID_PROJECT, idee.getIdProjet( ) );
        model.put( MARK_IDEA_TITLE_PROJECT, idee.getTitreProjet( ) );
        model.put( MARK_IDEA_URL_PROJECT, idee.getUrlProjet( ) );
        return model;
    }
    
     /**
     * {@inheritDoc}
     */
    @Override
    public String getIdDemand( int nIdRessource )
    {
        return Integer.toString( nIdRessource );
    }
    
     /**
     * {@inheritDoc}
     */
    @Override
    public String getUserGuid( int nIdRessource )
    {
        Idee idee = IdeeHome.findByPrimaryKey( nIdRessource );
        return idee.getLuteceUserName( );
    }
}
