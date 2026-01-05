# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is a Tessl-managed project named "airline-assistant-tessl". Tessl is used for tile-based dependency management and AI-assisted development workflows.

## Tessl Integration

The project uses Tessl MCP (Model Context Protocol) server for enhanced AI tooling:
- MCP server configured in `.mcp.json` with the `tessl` command
- Tessl project manifest: `tessl.json`
- Claude Code has MCP integration enabled via `.claude/settings.local.json`

### Available Tessl MCP Tools

Use these MCP tools (prefixed with `mcp__tessl__`) for Tessl operations:
- `mcp__tessl__search` - Search for tiles in the Tessl registry
- `mcp__tessl__install` - Install tiles from the registry or install all dependencies
- `mcp__tessl__uninstall` - Remove tiles from the project
- `mcp__tessl__status` - Check authentication and manifest sync status
- `mcp__tessl__query_library_docs` - Query curated documentation about libraries/dependencies
- `mcp__tessl__new_tile` - Create new Tessl tiles with documentation and/or rules
- `mcp__tessl__login` - Authenticate with Tessl registry

When working with dependencies or looking for existing solutions, prefer using `mcp__tessl__query_library_docs` to find available abstractions before implementing from scratch.

## Project State

This is a newly initialized project with minimal setup. Source code, build tools, and development scripts will be added as the project develops.
