import * as React from 'react';
import AppBar from '@mui/material/AppBar';
import CssBaseline from '@mui/material/CssBaseline';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography'
import Grid from '@mui/material/Grid';
import "../../../package.json"

export default function BottomAppBar() {

  // const packageVersion = require('../../../package.json').version;

  return (
    <React.Fragment>
      <CssBaseline />
      <AppBar position="fixed" sx={{ top: 'auto', bottom: 0 ,backgroundColor: '#00897b'  }}>
        <Toolbar>
        <Grid container>
        <Grid item xs={6}>
        <Typography
            variant="h6"
            noWrap
            component="a"
            href="#app-bar-with-responsive-menu"
            
            sx={{
              ml: 1,
              display: { xs: 'none', md: 'flex' },
              fontFamily: 'monospace',
              fontWeight: 600,
              fontSize:17,
              letterSpacing: '.1rem',
              color: 'inherit',
              textDecoration: 'none',
            }}
          >
            Canteen management system @2024-25 
            
          </Typography>
</Grid>
        <Grid item xs={6} style={{textAlign:"right"}}>
        
            {/* version {packageVersion} */}
            version 0.1
         
</Grid>
        </Grid>
        </Toolbar>
      </AppBar>
    </React.Fragment>
  );
}
