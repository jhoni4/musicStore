'use strict';
/**
 * 
 */
var gulp = require('gulp');
/**
 *  Welcome to your gulpfile!
 *  The gulp tasks are splitted in several files in the gulp directory
 *  because putting all here was really too long
 */


var git = require('gulp-git');
var replace = require('gulp-replace');

var sonar = require('gulp-sonar');
var util = require('util');


/*
SONAR
*/
gulp.task('default', function(){
	var options = {
	        sonar: {
	            host: {
	                url: 'http://localhost:9000'
	            },
	            projectKey: 'zRecord',
	            projectName: 'zRecord',
	            projectVersion: '1.0.0',
	            // comma-delimited string of source directories 
	            sources: '/Users/yonatanmolla/Documents/Workspace2/musicStore/zRecord/src/main/webapp/WEB-INF/resources/js/controller.js',
	            language: 'js',
	            sourceEncoding: 'UTF-8',
	            javascript: {
	                lcov: {
	                    reportPath: '/Users/yonatanmolla/Documents/Workspace2/musicStore/zRecord/src/main/webapp/WEB-INF/resources/js/lcov.info'
	                }
	            },
	            exec: {
	                // All these properties will be send to the child_process.exec method (see: https://nodejs.org/api/child_process.html#child_process_child_process_exec_command_options_callback ) 
	                // Increase the amount of data allowed on stdout or stderr (if this value is exceeded then the child process is killed, and the gulp-sonar will fail). 
	                maxBuffer : 1024*1024
	            }
	        }
	    };    
   
 
    // gulp source doesn't matter, all files are referenced in options object above 
    return gulp.src('thisFileDoesNotExist.js', { read: false })
        .pipe(sonar(options))
        .on('error', util.log);
});